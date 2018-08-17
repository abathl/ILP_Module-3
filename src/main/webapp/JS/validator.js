var validsubmit = false;

function validateStr(ref, regex) {

	console.log(ref);

	var str = $(ref).val();
	var strResult = regex.test(str);
	validsubmit = strResult;
	return !strResult;
};

$("#claimForm").submit(function(e) {
	// console.log("inside CUid validator");
	if (validsubmit == false) {
		e.preventDefault();
		// console.log("submit prevented");
	} else {
		$("#claimForm").submit();
		// console.log("submitted");
	}

});

$("#exampleInputFile").change(
		function() {
			var fileName = $("#exampleInputFile").val();
			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			console.log(fileName);
			$("#fileLabelId").text(fileName);
			var fileExtension = [ 'jpeg', 'jpg', 'png', 'gif', 'bmp', 'pdf' ];
			$("#exampleInputFile").toggleClass(
					'is-invalid',
					$.inArray($(this).val().split('.').pop().toLowerCase(),
							fileExtension) == -1);
		});

$("#inputEmail").on(
		'change keyup',
		function() {
			$("#inputEmail").toggleClass(
					'is-invalid',
					validateStr(this,
							/^[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}.[a-zA-Z]{1,}$/));
		});

$("#inputFullName").on(
		'change keyup',
		function() {
			$("#inputFullName").toggleClass('is-invalid',
					validateStr(this, /^CU[0-9]{1,}$/));
		});
