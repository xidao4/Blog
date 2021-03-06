import { axios } from '../utils/request.js'
const api = {
    userPre: '/api/user'
}
export function loginAPI(data){
    return axios({
        url:`${api.userPre}/login`,
        method: 'POST',
        data
    })
}
export function registerAPI(data){
    return axios({
        url:`${api.userPre}/register`,
        method: 'POST',
        data
    })
}
export function getUserInfoAPI(id){
    return axios({
        url: `${api.userPre}/${id}/getUserInfo`,
        method: 'GET'
    })
}
export function updateInfoAPI(id,data){
    return axios({
        url: `${api.userPre}/${id}/userInfo/update`,
        method: 'POST',
        data
    })
}
export function addFriendUrlAPI(data){
    return axios({
        url: `${api.userPre}/addFriendUrl`,
        method: 'POST',
        data
    })
}

export function getFriendUrlAPI(id){
    return axios({
        url: `${api.userPre}/${id}/getFriendUrl`,
        method: 'GET'
    })
}

export function deleteFriendUrlAPI(data){
    return axios({
        url: `${api.userPre}/deleteFriendUrl`,
        method: 'POST',
        data
    })
}

export function getUserNameAPI(id) {
    return axios({
        url: `${api.userPre}/${id}/getUserName`,
        method: 'GET'
    })
}

export function uploadAvatarAPI(id,data){
    return axios({
        url: `${api.userPre}/${id}/setUrl`,
        method: 'POST',
        params:{url: data},
    })
}