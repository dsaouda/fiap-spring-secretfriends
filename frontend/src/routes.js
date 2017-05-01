import Home from './components/Home.vue'
import Cadastro from './components/Cadastro.vue'
import Grupo from './components/Grupo.vue'
import GrupoCadastro from './components/GrupoCadastro.vue'

export const routes = [{
    name: 'home',
    path: '/',
    component: Home
}, {
    name: 'cadastro',
    path: '/cadastro',
    component: Cadastro,
},{
    name: 'grupo',
    path: '/grupo',
    component: Grupo,
},{
    name: 'grupo/cadastro',
    path: '/grupo/cadastro',
    component: GrupoCadastro,
}]
