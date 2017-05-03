import axios from 'axios';

const HOST = 'http://localhost:8092';

class Http {

    constructor(options) {
        this.axios = axios.create(options);
        let self = this;
        this.axios.interceptors.response.use(function (response) {    
            return response.data;
        }, function (error) {
            self._modalIfError(error);
            return Promise.reject(error.response.data);
        });
    }

    _modalIfError(error) {
        if ($('.ui.modal.nao-autenticado').length) {
            return ;
        }

        if (error.response.status === 403) {
            $('body').append(`
                <div class="ui modal nao-autenticado">
                    <div class="header">Não autorizado!</div>
                    <div class="content">
                        <p>Você precisa se autenticar para acessar esse recurso</p>
                    </div>
                    <div class="actions">
                        <a href="/" class="ui approve button">Ir para página de Login</a>                    
                    </div>
                </div>`
            );
            $('.ui.modal.nao-autenticado').modal('show');
        }

        if (error.response.status >= 500) {
            $('body').append(`
                <div class="ui modal nao-autenticado">
                    <div class="header">Erro não esperado</div>
                    <div class="content">
                        <p>Ocorreu um erro não esperado no servidor, tente novamente ou entre em contato com administrador</p>
                    </div>
                    <div class="actions">
                        <a href="/#/grupo" class="ui approve button">Continuar</a>                    
                    </div>
                </div>`
            );
            $('.ui.modal.nao-autenticado').modal('show');
        }
    }

    post(uri, params) {         
        return this.axios.post(uri, params);
    }

    get(uri, params) {
        return this.axios.get(uri, params);
    }
}

const rpcOpen = new Http({
    baseURL: `${HOST}/open/rpc/v1`,
    withCredentials:true,
    headers: {
        'Content-Type': 'application/json'
    }
});

const rpc = new Http({
    baseURL: `${HOST}/rpc/v1`,
    withCredentials:true,
    headers: {
        'Content-Type': 'application/json'
    }
    
});

const rest = new Http({
    baseURL: `${HOST}/rest/v1`,
    withCredentials:true,
    headers: {
        'Content-Type': 'application/json'
    }
});

export {rpcOpen, rest, rpc};