class ParticipanteService {

    constructor(http) {
        this.$http = http;
    }

    participar(grupoUid) {
        return $http.post('/participante', { grupo: grupoUid });
    }

    getParticipacoes() {
        return $http.get('/participante');
    }
}

import { rest as $http } from './http.js';
export default new ParticipanteService($http);