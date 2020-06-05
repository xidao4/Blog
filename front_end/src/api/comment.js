import { axios } from '../utils/request.js'
const api = {
    commentPre: '/api/comment'
}
export function getCommentByPassageIdAPI(passageId) {
    return axios({
        url:`${api.commentPre}/${passageId}/getCommentByPassageId`,
        method: 'GET',
    })
}