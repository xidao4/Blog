const getters={
    //passages
    searchResult:state=>state.passages.searchResult,
    passageDetail:state=>state.passages.passageDetail,
    //user
    //getter能干啥来着。。。
    token: state => state.user.token,
   
}
export default getters