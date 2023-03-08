//FileManger.js


//const fileAdd = document.getElementById("fileAdd");
const fileList = document.getElementById("fileList");

let count=0;
let max=1;
let param='pic';
let idx=0;

function setCount(c){
    count=c;
}

function setParam(p){
    param=p;
}

function setMax(m){
    max=m;
}

$(".deleteCheck").click(function(){
    if($(this).prop('checked')){
        let result=confirm('파일이 영구 삭제 됩니다')

        if(result){
            count--;
        }else {
            $(this).prop("checked", false);
        }

    }else {
        if(count==5){
            console.log("idx : ", idx);
            $("#f"+(idx-1)).remove();
            return;
        }
        count++;
    }
})

$("#fileList").on("click", ".dels", function(e){
    // let id = $(this).attr("data-dels-id");
    // $("#"+id).remove();
    $(this).parent().remove();
    count--;
})

// fileList.addEventListener("click", function(e){
//     if(e.target.classList.contains('dels')){
//         e.target.parentNode.remove();
//     //    let id = e.target.getAttribute('data-dels-id');
//     //    document.getElementById(id).remove(); 
//        count--;
//     }
// });
//function(){} : ()=>{}
$("#fileAdd").click(()=>{
    if(count>=max){
        alert('첨부파일은 최대 '+max+ ' 까지만 가능');
        return;
    }

    count++;
    let child = '<div class="input-group mb-3 my-3" id="f'+idx+'">';
        child = child+ '<input type="file" class="form-control" name="'+param+'">'
        child = child+ '<button type="button" class="btn btn-outline-danger dels" data-dels-id="f'+idx+'">X</button>'
        child = child+ '</div>'
    $("#fileList").append(child);

    idx++;
    
});

// //fileAdd.addEventListener("click", function(){

//     if(count>=max){
//         alert('첨부파일은 최대 '+max+ ' 까지만 가능');
//         return;
//     }

//     count++;

//     //Element, Text 들을 생성
//     let d = document.createElement('div');// 부모 DIV
//    // let l = document.createElement('label');//label
//    // let t = document.createTextNode('Image');
//     let i = document.createElement('input');//input
//     let b = document.createElement('button');//button

//     //Element들을 조합
//     //d.appendChild(l);
//     d.appendChild(i);
//     d.appendChild(b);

//     //attribute 생성 적용
//     //div
//     let attr = document.createAttribute("class");
//     attr.value='input-group mb-3';
//     d.setAttributeNode(attr);

//     attr = document.createAttribute("id");
//     attr.value='f'+idx;
//     d.setAttributeNode(attr);

    

//     //label
//     //attr = document.createAttribute("class");
//     //attr.value='form-label';
//     //l.setAttributeNode(attr);

//     //attr = document.createAttribute("for");
//     //attr.value='files';
//     //l.setAttributeNode(attr);

//     //input
//     attr = document.createAttribute("type");
//     attr.value="file";
//     i.setAttributeNode(attr);

//     attr = document.createAttribute("class");
//     attr.value='form-control';
//     i.setAttributeNode(attr);

//     attr = document.createAttribute("id");
//     attr.value='files';
//     i.setAttributeNode(attr);

//     attr = document.createAttribute("name");
//     attr.value=param;
//     i.setAttributeNode(attr);

//     //button
//     attr = document.createAttribute("type");
//     attr.value="button";
//     b.setAttributeNode(attr);
//     attr= document.createAttribute("class");
//     attr.value="btn btn-outline-danger dels";
//     b.setAttributeNode(attr);
//     attr = document.createTextNode("X");
//     b.appendChild(attr);

//     attr = document.createAttribute("data-dels-id");
//     attr.value='f'+idx;
//     b.setAttributeNode(attr);

//     idx++;

//     fileList.prepend(d);

// //});