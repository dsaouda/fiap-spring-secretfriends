import axios from 'axios';

const HOST = 'http://localhost:8092';

const rpcOpen = axios.create({
    baseURL: `${HOST}/open/rpc/v1`,
    withCredentials:true
});

const rpc = axios.create({
    baseURL: `${HOST}/rpc/v1`,
    withCredentials:true
});

const rest = axios.create({
    baseURL: `${HOST}/rest/v1`,
    withCredentials:true
});

export {rpcOpen, rest, rpc};