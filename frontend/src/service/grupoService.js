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

    criar(grupo) {
        return $http.post('/grupo', grupo);
    }

    getAll(context) {
        return $http.get('/grupo').then(response => {
            context.grupos = response;
        });;
    }
}

import { rest as $http } from './http.js';
export default new GrupoService($http);