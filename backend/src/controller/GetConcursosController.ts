import { Request, Response } from 'express'
import puppeteer from 'puppeteer'


export class GetConcursosController {
  async handle(req: Request, res: Response) {
    
    const browser = await puppeteer.launch();
    const page = await browser.newPage();
    await page.goto("https://www.pciconcursos.com.br/concursos/centrooeste");


    const concursosListObject = await page.evaluate(() => {

      //Consegue os elementos principais da página
      const concursosList = document.getElementsByClassName("ca")
      const concursoCargoNivel = document.getElementsByClassName("cd")


      let qtd = 0
      //Descobre a qtd de concursos do DF
      const arrayConcursosQtd = [ ...concursosList ]
      const concursosQtd = arrayConcursosQtd
      .map((item) => {
        const uf = item.getElementsByClassName("cc")[0].innerHTML
        if (uf === "DF")
          qtd++   
      })


      //Acha as informações separadamente e monta a lista de concursos
     
      //Outro jeito de filtar os dados.
      //const concursoNome = document.getElementsByClassName("ca")[1]
                             //.getElementsByTagName("a")[0].innerHTML


      let concursoDados = []

      for (let i = 0; i < qtd; i++) {

        const concursoNome = concursosList[i].getElementsByTagName("a")[0].innerHTML

        const concursoVagasSalario = concursosList[i]
                             .getElementsByClassName("cd")[0].innerHTML
                             .split("<br>")[0].split(" até ")

        const concursoVagas = concursoVagasSalario[0]

        const concursoSalario = concursoVagasSalario[1]

   
        const concursoCargo = concursoCargoNivel[i]
                              .getElementsByTagName("span")[0].innerHTML.split("<br>")[0]

        const concursoNivel = concursoCargoNivel[i].getElementsByTagName("span")[1].innerHTML

        const concursoInscricao = concursosList[i].getElementsByClassName("ce")[0]
                             .getElementsByTagName("span")[0].innerText.replace(/\n/g, " ")



        concursoDados.push({
          nome: concursoNome,
          vagas: concursoVagas,
          salario: concursoSalario,
          cargo: concursoCargo,
          nivel: concursoNivel,
          inscricao: concursoInscricao,      
        })

      }

                             


      return {concursoDados, qtd}
    });

   
    await browser.close();
    console.log("ok")
    console.log(concursosListObject.qtd)


    return res.status(200).json(concursosListObject.concursoDados)
  }
}

