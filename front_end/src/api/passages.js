import { axios } from '../utils/request.js'
const api = {
    passagesPre: '/api/passages'
}
export function searchAPI(key){
    return axios({
        url:`${api.passagesPre}/${key}/searchPassages`,
        method: 'GET',
    })
}