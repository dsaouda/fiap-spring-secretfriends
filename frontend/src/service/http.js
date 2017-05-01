import axios from 'axios';

const rcpOpen = axios.create({
    baseURL: 'http://localhost:8090/open/rpc/v1',
    withCredentials:true
});

const rest = axios.create({
    baseURL: 'http://localhost:8090/rest/v1',
    withCredentials:true
});

export {rcpOpen, rest};