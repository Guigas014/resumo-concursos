package com.guilherme.concursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilherme.concursos.domain.cargo.Cargo;
import com.guilherme.concursos.domain.cargo.exceptions.CargoNotFoundException;
import com.guilherme.concursos.domain.avaliacao.Avaliacao;
import com.guilherme.concursos.domain.avaliacao.exceptions.AvaliacaoNotFoundException;
import com.guilherme.concursos.domain.concurso.Concurso;
import com.guilherme.concursos.domain.concurso.exceptions.ConcursoNotFoundException;
import com.guilherme.concursos.domain.conteudo.Conteudo;
import com.guilherme.concursos.domain.conteudo.exceptions.ConteudoNotFoundException;
import com.guilherme.concursos.dto.avaliacao.AvaliacaoDetailsDTO;
import com.guilherme.concursos.dto.avaliacao.AvaliacaoResponseDTO;
import com.guilherme.concursos.dto.cargo.CargoResponseDTO;
import com.guilherme.concursos.dto.conteudo.ConteudoResponseDTO;
import com.guilherme.concursos.repositories.AvaliacaoRepository;
import com.guilherme.concursos.repositories.CargoRepository;
import com.guilherme.concursos.repositories.ConcursoRepository;
import com.guilherme.concursos.repositories.ConteudoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcursoService {

      private final CargoRepository cargoRepository;
      private final ConcursoRepository concursoRepository;
      private final AvaliacaoRepository avaliacaoRepository;
      private final ConteudoRepository conteudoRepository;

      public List<CargoResponseDTO> getCargos(String concursoId) {
            Optional<Concurso> concurso = concursoRepository.findById(concursoId);

            if (!concurso.isPresent()) {
                  throw new ConcursoNotFoundException("Concurso não encontrado!");
            }

            List<Cargo> cargos = this.cargoRepository.findByConcursoId(concursoId);

            // PENSAR SE ARRUMO OU DESISTO DESSE TRATAMENTO DE ERRO
            if (cargos.isEmpty()) {
                  System.out.println("Nenhum cargo cadastrado!");
            }

            List<CargoResponseDTO> cargosDTO = cargos.stream().map(item -> {
                  CargoResponseDTO cargoDTO = new CargoResponseDTO(item.getId(), item.getNome(), item.getNivel(),
                              item.getCadastroReserva(), item.getQuantidadeVagas(), item.getTaxaInscricao(),
                              item.getSalario(), concurso.get().getNome(), concurso.get().getFimInscricao());

                  return cargoDTO;
            }).toList();

            return cargosDTO;
      }

      @Transactional
      public String createCargo(Cargo dados, String concursoId) {
            Optional<Concurso> concurso = concursoRepository.findById(concursoId);

            if (!concurso.isPresent()) {
                  // System.out.println("Concurso não encontrado!");
                  // String message = "Concurso não encontrado!";

                  // return message;

                  throw new ConcursoNotFoundException("Concurso não encontrado!");
            }

            // System.out.println(dados);

            Cargo cargo = new Cargo();

            cargo.setNome(dados.getNome());
            cargo.setNivel(dados.getNivel());
            cargo.setCadastroReserva(dados.getCadastroReserva());
            cargo.setQuantidadeVagas(dados.getQuantidadeVagas());
            cargo.setSalario(dados.getSalario());
            cargo.setTaxaInscricao(dados.getTaxaInscricao());
            cargo.setConcurso(concurso.get());

            this.cargoRepository.save(cargo);

            return cargo.getId();
      }

      @Transactional
      public String createAvaliacao(Avaliacao dados, String cargoId) {
            Optional<Cargo> cargo = cargoRepository.findById(cargoId);

            if (!cargo.isPresent()) {
                  throw new CargoNotFoundException("Cargo não encontrado!");
            }

            Avaliacao avaliacao = new Avaliacao();

            avaliacao.setTipo(dados.getTipo());
            avaliacao.setCarater(dados.getCarater());
            avaliacao.setPontuacao(dados.getPontuacao());
            avaliacao.setDataProva(dados.getDataProva());
            avaliacao.setDuracao(dados.getDuracao());
            avaliacao.setQuantidadeQuestoes(dados.getQuantidadeQuestoes());
            avaliacao.setCargo(cargo.get());

            this.avaliacaoRepository.save(avaliacao);

            return avaliacao.getId();
      }

      @Transactional
      public String createConteudo(Conteudo dados, String avaliacaoId) {
            Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(avaliacaoId);

            if (!avaliacao.isPresent()) {
                  throw new AvaliacaoNotFoundException("Avaliação não encontrado!");
            }

            Conteudo conteudo = new Conteudo();

            conteudo.setPortugues(dados.isPortugues());
            conteudo.setMatematica(dados.isMatematica());
            conteudo.setInformatica(dados.isInformatica());
            conteudo.setRaciocinio_logico(dados.isRaciocinio_logico());
            conteudo.setIngles(dados.isIngles());
            conteudo.setEtica(dados.isEtica());
            conteudo.setAtualidades(dados.isAtualidades());
            conteudo.setDireito_administrativo(dados.isDireito_administrativo());
            conteudo.setDireito_constitucional(dados.isDireito_constitucional());
            conteudo.setEspecifico(dados.isEspecifico());

            conteudo.setOutros(dados.getOutros());
            conteudo.setAvaliacao(avaliacao.get());

            this.conteudoRepository.save(conteudo);

            return conteudo.getId();
      }

      @Transactional
      public List<AvaliacaoResponseDTO> getAvaliacoes(String cargoId) {
            Optional<Cargo> cargo = cargoRepository.findById(cargoId);

            if (!cargo.isPresent()) {
                  throw new CargoNotFoundException("Cargo não encontrado!");
            }

            List<Avaliacao> avaliacoes = avaliacaoRepository.findByCargoId(cargoId);

            List<AvaliacaoResponseDTO> avaliacoesDTO = avaliacoes.stream().map(item -> {
                  ConteudoResponseDTO conteudo = this.getConteudo(item.getId());

                  AvaliacaoResponseDTO avaliacaoDTO = new AvaliacaoResponseDTO(item.getCargo().getConcurso().getNome(),
                              item.getCargo().getNome(),
                              new AvaliacaoDetailsDTO(item.getId(), item.getTipo(), item.getCarater(),
                                          item.getPontuacao(), item.getDataProva(), item.getDuracao(),
                                          item.getQuantidadeQuestoes()),
                              conteudo);

                  return avaliacaoDTO;
            }).toList();

            return avaliacoesDTO;
      }

      public ConteudoResponseDTO getConteudo(String avaliacaoId) {
            Optional<Conteudo> conteudo = this.conteudoRepository.findByAvaliacaoId(avaliacaoId);

            // System.out.println(avaliacaoId);

            if (!conteudo.isPresent()) {
                  throw new ConteudoNotFoundException("Conteúdo não encontrado!");
                  // System.out.println("Conteudo nao encontrado");
            }

            List<ConteudoResponseDTO> conteudoDTO = conteudo.stream().map(item -> {
                  ConteudoResponseDTO newConteudo = new ConteudoResponseDTO(item.isPortugues(), item.isMatematica(),
                              item.isInformatica(), item.isRaciocinio_logico(), item.isIngles(), item.isEtica(),
                              item.isAtualidades(), item.isDireito_administrativo(), item.isDireito_constitucional(),
                              item.isEspecifico(), item.getOutros());

                  return newConteudo;
            }).toList();

            return conteudoDTO.get(0);
      }

}
