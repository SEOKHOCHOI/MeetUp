import axios from "axios";

/*
  GET: axios.get(rul[, config])
  POST: axios.post(url, data[, config])
  PUT: axios.put(url, data[, config])
  DELETE: axios.delete(url[, config])

  axios의 4가지 기본 메서드를 사용하기 위해 지정해야 할건?
  4가지의 기본 Params
  1. Method
  2. Url
  3. Data(optional)
  4. Params(optional)

  ex) axios({
        method: "get",
        url: "url",
        responseType: "type"
      }).then(function (response) { // response Action }) 

      POST 메서드에서 data를 전송하기 위해서는 url 밑에 
      data Object를 추가하면 된다.

      단축된 axios 메서드
      위의 4가지 기본 파라미터 생략 or 간결하게 사용가능.
      axios.get("url")
          .then(function(response) {// response})
          .catch(function(error) {// 오류 발생시 실행})
          .then(function(){// 항상 실행});
      
      async await 함수를 사용할 때,

      try {
        const data = await axios.get("url");
      } catch { // 오류 발생시 실행 }
*/

const API = axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-Type": "application/json",
  },
  withCredentials: true,
});

export default API;
