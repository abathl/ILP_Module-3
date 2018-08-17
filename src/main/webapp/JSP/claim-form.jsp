<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="claim-container"> 
	<form method="post" class="col-md-12">
		<div class="form-group row">
				<label for="policSel"  class="col-sm-2 col-form-label">Select Policies:</label>
				<div class="col-sm-10">
					<select class="form-control" name="policySel">
						<option>Canada</option>
						<option>Italy</option>
						<option>USA</option>
						<option>Brazil</option>
					 </select>
				</div>
			</div>
		<div class="form-group row">
			<label for="inputEmail" class="col-sm-2 col-form-label">Nominee:</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" name="claimNominee" placeholder="John Doe" required disabled>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="inputDOB" class="col-sm-2 col-form-label">Date of Birth:</label>
			<div class="col-sm-10">
				<input type="date" class="form-control" id="inputDOB" placeholder="DD/MM/YYYY" required>
			</div>
		</div>
		
		<div class="offset-sm-3 form-group row" style="display:flex; justify-content:space-between; width: 60%;">
			<button id="deathButton" type="button" class="btn btn-primary">Death Of Policy Holder</button>
			<button id="policyMatured" type="button" class="btn btn-primary">Policy Matured</button>
			<button id="interClaim" type="button" class="btn btn-primary">Intermittent Claim</button>
		</div>
		
		<div class="upload offset-sm-2 form-group row">
			<div class="custom-file" id="customFile" lang="es" style="width:98%">
				<input type="file" class="custom-file-input" name="deathCert">
				<label class="custom-file-label" for="deathCert">
				   Select file...
				</label>
			</div>
		</div>
		
		<div class="moreInfoText form-group row">
			
			<label for="moreInfo" class="col-form-label col-sm-2 ">More Info:</label>
			
			<div class="offset-sm-2 col-sm-10">
  				<textarea class="form-control" rows="5" name="moreInfo"></textarea>
			</div>
		</div>
		
		<div class="form-group row buttons">
			<div>
				<button id="submit" type="submit" class="btn btn-primary">Submit</button>
			</div>
		</div>
	</form>
</div>