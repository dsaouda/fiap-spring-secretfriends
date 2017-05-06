class ConviteService {

    constructor(http) {
        this.$http = http;
    }

    getEnviados(grupoUid) {
        return $http.post('/convite/enviados', {grupo: grupoUid});
    }

    recebidos(context) {
        $http.post('/convite/recebidos')
            .then(r => {
                context.convites = r.data;
            }).catch(e => {            
                
            });
    }

    rejeitar(grupoUid) {
        return $http.post('/convite/rejeitar', {grupo: grupoUid});
    }

    enviar(convite) {
        return $http.post('/convite/enviar', convite);
    }
   
}

import {rpc as $http} from '../service/http.js';
export default new ConviteService($http);