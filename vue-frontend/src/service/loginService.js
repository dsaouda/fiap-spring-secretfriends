class LoginService {

    constructor(http) {
        this.$http = http;
    }

    logar(context) {
        context.message = '';
        return $http.post('/login', context.login).then(r => {
            context.$router.push('/grupos');
        }).catch(e => {
            if (e.message) {
                context.message = e.message;
            }
        });;
    }
}

import { rpcOpen as $http } from './http.js';
export default new LoginService($http);