$(document).ready(function() {
	
	$('.nBtn, .table .eBtn').on('click', function(event){	
		event.preventDefault();
		var href = $(this).attr('href');
		var btntext = $(this).text();
		
		if(btntext=='Редактировать') {
			
			$.get(href, function(vacancy, status){				
				setModalParams('Редактивание вакансии',vacancy.id, vacancy.title, vacancy.describe,vacancy.salary, vacancy.visible);		
			})	
				
		} else {	
			setModalParams('Новая вакансия', '', '', '', '', false);
		}		
	});
});



function setModalParams(label, id, title, describe, salary, visible){
	$('.myForm #modelLabel').text(label);
	$('.myForm #id').val(id);
	$('.myForm #title').val(title);
	$('.myForm #describe').val(describe);
	$('.myForm #salary').val(salary);
	$('.myForm #visible')[0].checked = visible;	
	$('.myForm #exampleModal').modal();
}