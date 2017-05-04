class ParticipanteService {

    constructor(http) {
        this.$http = http;
    }

    participar(grupoUid) {
        return $http.post('/participante', { grupo: grupoUid });
    }
}

import { rest as $http } from './http.js';
export default new ParticipanteService($http);