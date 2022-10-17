import { Router } from 'express'
import { GetConcursosController } from './controller/GetConcursosController'


const router = Router()

router.get('/', new GetConcursosController().handle)


export { router }

