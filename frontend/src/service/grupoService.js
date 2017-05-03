class GrupoService {

    constructor(http) {
        this.$http = http;
    }

    setComponent(component) {
        this.component = component;
    }

    getAll() {        
        return $http.get('/grupo').then(r => {
            this.component.grupos = r.data;
        });;
    }
}

import {rest as $http} from './http.js';
export default new GrupoService($http);