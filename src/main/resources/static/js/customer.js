$(document).ready(function() {
	
	$('.table .oBtn').on('click', function(event){	
		event.preventDefault();
		
		var row = $(this).closest("tr");
		var title = row.find(".title").text()
		var vacancyID = row.find(".vacancyID").text();
		
		$('.myForm #modelLabel').text("отклик на вакансию " + title);
		$('.myForm #vacancyId').val(vacancyID);
		
		$('.myForm #exampleModal').modal();
		
	});
});

