class GrupoService {

    constructor(http) {
        this.$http = http;
    }

    get(context, uuid) {
         $http.get(`/grupo/${uuid}`)
            .then(r => {
                context.grupo = r.data;
            });
    }

    criar(context) {
        context.errors = {};
        context.message = '';

        $http.post('/grupo', context.grupo)
            .then(response => {
                flashMessage.set('message', 'Grupo cadastrado com sucesso');
                context.$router.push('/grupo');
            }).catch(e => {
                let error = e.response.data;
                
                if (error.data) {
                    context.errors = error.data;
                }

                if (error.message) {
                    context.message = error.message;
                }
            });
    }

    getAll(context) {        
        return $http.get('/grupo').then(response => {            
            context.grupos = response;
        });;
    }
}

import {rest as $http} from './http.js';
export default new GrupoService($http);