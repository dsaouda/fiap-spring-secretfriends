class LoginService {

    constructor(http) {
        this.$http = http;
    }

    logar(params) {
        return $http.post('/login', params);
    }
}

import {rpcOpen as $http} from './http.js';
export default new LoginService($http);