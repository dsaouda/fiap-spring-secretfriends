class ConviteService {

    constructor(http) {
        this.$http = http;
    }

    getEnviados(context, grupoUid) {
        $http.post('/convite/enviados', {grupo: grupoUid}).then(r => {
            context.convitesEnviados = r.data;                  
        });
    }

    enviar(context) {
        context.messageSuccess = '';
        context.messageError = '';

        $http.post('/convite/enviar', context.convite)
            .then(r => {
                context.messageSuccess = 'Convite enviado com sucesso!';
                context.grupo.email = '';
                
            }).catch(e => {            
                context.messageError = e.message;
            });
    }
   
}

import {rpc as $http} from '../service/http.js';
export default new ConviteService($http);