import express from 'express' 
//import puppeteer from 'puppeteer'

import { router } from './routes'


const app = express() 

app.use(express.json())
app.use(router)

/*app.get('/', async (req, res) => {

  const browser = await puppeteer.launch();
  const page = await browser.newPage();
  await page.goto("https://www.pciconcursos.com.br/concursos/centrooeste");

  const concursosList = await page.evaluate(() => {
    const concursoTeste = document.getElementsByClassName("ca")[1]
                             .getElementsByClassName("cc")[0].innerHTML

    const concursoNome = document.getElementsByClassName("ca")[1]
                             .getElementsByTagName("a")[0].innerHTML

    const concursoVagasSalario = document.getElementsByClassName("ca")[1]
                             .getElementsByClassName("cd")[0].innerHTML
                             .split("<br>")[0].split(" até ")

    const concursoVagas = concursoVagasSalario[0]

    const concursoSalario = concursoVagasSalario[1]

   
    const concursoCargo = document.getElementsByClassName("cd")[1]
                             .getElementsByTagName("span")[0].innerHTML.split("<br>")[0]

    const concursoNivel = document.getElementsByClassName("cd")[1]
                             .getElementsByTagName("span")[1].innerHTML

    const concursoInscricao = document.getElementsByClassName("ca")[1]
                             .getElementsByClassName("ce")[0]
                             .getElementsByTagName("span")[0].innerText.replace(/\n/g, " ")


                             
    const concursoDados = {
      nome: concursoNome,
      vagas: concursoVagas,
      salario: concursoSalario,
      cargo: concursoCargo,
      nivel: concursoNivel,
      inscricao: concursoInscricao,      
    }

    return concursoDados
  });

   
  await browser.close();
  console.log("ok")

  //console.log(concursosList)


  return res.status(200).json(concursosList)
  
}) */



app.listen(3000, () => console.log('Server is running'))

