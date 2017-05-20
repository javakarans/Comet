function showOrderDetails(id) {
    var displayDetail=$('#'.concat(id)).css('display');
    if(displayDetail=='none'){
        $('#'.concat(id)).css('display','');
    }else {
        $('#'.concat(id)).css('display','none');
    }

}