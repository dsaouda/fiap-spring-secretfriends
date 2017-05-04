import Home from './components/Home.vue'
import Cadastro from './components/Cadastro.vue'
import Grupo from './components/Grupo.vue'
import GrupoCadastro from './components/GrupoCadastro.vue'
import GrupoParticipando from './components/GrupoParticipando.vue'
import Convites from './components/Convites.vue'
import Convidar from './components/Convidar.vue'

export const routes = [{
    name: 'home',
    path: '/',
    component: Home
}, {
    name: 'cadastro',
    path: '/cadastro',
    component: Cadastro,
}, {
    name: 'grupos',
    path: '/grupos',
    component: Grupo,
}, {
    name: 'grupo/cadastro',
    path: '/grupo/cadastro',
    component: GrupoCadastro,
}, {
    name: 'grupos_participando',
    path: '/grupos/participando',
    component: GrupoParticipando,
}, {
    name: 'convites',
    path: '/convites',
    component: Convites,
}, {
    name: 'convidar',
    path: '/convidar',
    component: Convidar,
}];