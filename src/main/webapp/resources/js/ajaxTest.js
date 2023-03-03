const btn = document.getElementById("btn");

btn.addEventListener("click", function(){

    let xhttp = new XMLHttpRequest();

    xhttp.open('GET', '/notice/list?page=1');

    xhttp.send();
    
    xhttp.addEventListener('readystatechange', function(){
        if(this.readyState==4 && this.status==200){
            console.log("정상 요청 응답 종료");
            console.log(this.responseText);
        }

    });

});