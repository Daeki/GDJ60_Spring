
$("#btn").click(()=>{

    let productId = $("#productId").val();

    $.ajax({
        type:'GET',
        url:"https://dummyjson.com/products/"+productId,
        success:function(response){
            console.log(response);
            console.log(typeof response);
        }
    });

    // $.get("https://dummyjson.com/products/"+productId, (response)=>{
    //     console.log(response);
    //     console.log(response.title);
    //     console.log(typeof response);
    //     alert(response);
    //     let result = JSON.stringify(response);
    //     console.log(result);
    //     alert(result);
    //     console.log(typeof result);
    //     console.log(result.title);
    // });

})

$.get("https://dummyjson.com/products/", (response)=>{
    console.log(response.products.length);
    //let result="";
    for(let item of response.products){
        console.log(item);
        let result = '<div class="card" style="width: 18rem;">';
        result = result + '<img src="'+item.thumbnail+'" class="card-img-top" alt="...">';
        result = result + '<div class="card-body"></div>'
        result = result + '<h5 class="card-title">'+item.title+'</h5>'
        result = result + '<p class="card-text">'+item.description+'</p>';
        result = result + '<a href="#" class="btn btn-primary detail" data-productId="'+item.id+'">'+item.price+'</a>';
        result = result + '</div></div>';
        $("#productList").append(result);
    }

    //$("#productList").html(result);
        
    
});

$("#productList").on("click", ".detail", function(e){
    console.log("ID : ", $(this).attr("data-productId"));
    $.get("https://dummyjson.com/products/"+$(this).attr("data-productId"), (response)=>{
        console.log(response);
        console.log(response.title);
    });
    e.preventDefault();
})





