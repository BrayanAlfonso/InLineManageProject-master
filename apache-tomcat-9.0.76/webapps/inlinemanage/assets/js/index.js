let menuUser=document.querySelector(".menuUser")
menuUser.addEventListener("mouseover",()=>{
    let userOptions=document.querySelector(".userOptions")
    
    userOptions.style.display="block";

    iconUser.addEventListener("mouseout", ()=>{
        setTimeout(()=>{
            userOptions.style.display="none";
        },2000)
            
        
    })
})
