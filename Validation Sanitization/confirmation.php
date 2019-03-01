<!-- Assigment 3 -->
<!-- Trevor Storey -->
<!-- Jan 23, 2019 --> 

<?php 
    // Set initial values 
    // strings set to blank
    $name='';
    $address='';
    $city='';
    $province='';
    $postCode='';
    $email='';
    $cardType='';
    $cardName='';
    $month='';
    $year='';
    $cardNum='';

    // numbers set to 0
    $imac=0;
    $mouse=0;
    $wd=0;
    $nexus=0;
    $drums=0;
    
    // how we decided to show error page or order form
    $valid = TRUE;

    // checks if submit button clicked
    if(isset($_POST['submit'])){

        // email validation
        // checks again filter email validation
       if(filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL)){
            $email = $_POST['email'];    
       } else {
           $valid = FALSE;
           echo "<p> invalid email </p>";
       }

       // postal code validation
       // regex from internet
       // preg match from notes. Thought I would try it for at least one
       if(preg_match('/[A-Za-z][0-9][A-Za-z][ -]?[0-9][A-Za-z][0-9]/', $_POST['postal'])) {
           $postCode = $_POST['postal'];
       }else {
           $valid = FALSE;
           echo "<p> invalid postal code </p>";
       }

       // cardnumber validation
       // checks if float (float because int stop around 2billion) also checks size of string
       if(filter_input(INPUT_POST, 'cardnumber', FILTER_VALIDATE_FLOAT) && strlen((string)$_POST['cardnumber']) == 10){
            $cardNumber = $_POST['cardnumber'];
       } else {
            $valid = FALSE;
            echo "<p> invalid cardnumber </p>";
       }

       // Validate month
       // checks if blank
       // checks if month value is valid
       if(empty($_POST['month'])){
           $valid = FALSE;
           echo "<p> no month </p>";
       } else if ($_POST['month'] < 1 || $_POST['month'] > 12){
           $valid = FALSE;
           echo "<p> invalid month </p>";
       } else {
           $month = $_POST['month'];
       }

       // year validation
       // checks if blank
       // checks year against todays date + 5 years 
       if(empty($_POST['year'])) {
           $valid = FALSE;
           echo "<p> No Year </p>";           
        } else {
            if(filter_input(INPUT_POST, 'year', FILTER_VALIDATE_INT, array("options" => array("min_range"=>date("Y"), "max_range"=>date("Y")+ 5)) )){
                $year = $_POST['year'];
            } else {
                $valid = FALSE;
                echo "<p> invalid year </p>";
            }
        }

       // card type validation
       // regex made by yours truely (with help from internet)
       if(filter_input(INPUT_POST, 'cardtype', FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^(?:visa|amex|mastercard)*$/")))){
            $cardType = $_POST['cardtype'];
        } else {
            $valid =  FALSE;
            echo "<p> invalid cardtype </p>";
        }

        // Province validation
        // regex from internet
        if(filter_input(INPUT_POST, 'province', FILTER_VALIDATE_REGEXP, array("options" => array("regexp" => "/^(?:AB|BC|MB|NB|NL|NS|ON|PE|QC|SK|NT|NU|YT)*$/")))){
			$province = $_POST['province'];
		} else {
            echo "<p> invalid province </p>";
            $valid = FALSE;
        }

        // full name / card name / address / city validations 
        // checks if blank
        if(empty($_POST['fullname'])) {
            $valid = FALSE;  
            echo "<p> invalid fullname </p>";         
        } else {
            $name = $_POST['fullname'];
        }

        if(empty($_POST['cardname'])) {
            $valid = FALSE; 
            echo "<p> invalid cardname </p>";          
        } else {
            $cardName = $_POST['cardname'];
        }

        if(empty($_POST['address'])) {
            $valid = FALSE; 
            echo "<p> invalid address </p>";          
        } else {
            $address = $_POST['address'];
        }

        if(empty($_POST['city'])) {
            $valid = FALSE; 
            echo "<p> invalid city </p>";         
        } else {
            $city = $_POST['city'];
        }


        // validate for order quantities
        // if empty set to 0
        // if not zero check if num  
        if($_POST['qty1']==""){
			$imac = 0;
        } else {
            if(filter_input(INPUT_POST, 'qty1', FILTER_VALIDATE_INT)){
                $imac = $_POST['qty1'];
            } else {
                $valid = FALSE;
                echo "<p> invalid qty1 </p>";
            }
        }
        
        if($_POST['qty2']==""){
			$mouse = 0;
        } else {
            if(filter_input(INPUT_POST, 'qty2', FILTER_VALIDATE_INT)){
                $mouse = $_POST['qty2'];
            } else {
                $valid = FALSE;
                echo "<p> invalid qty2 </p>";
            }
        }
        
        if($_POST['qty3']==""){
			$wd = 0;
        } else {
            if(filter_input(INPUT_POST, 'qty3', FILTER_VALIDATE_INT)){
                $wd = $_POST['qty3'];
            } else {
                $valid = FALSE;
                echo "<p> invalid qty3 </p>";
            }
        }
        
        if($_POST['qty4']==""){
			$nexus = 0;
        } else {
            if(filter_input(INPUT_POST, 'qty4', FILTER_VALIDATE_INT)){
                $nexus = $_POST['qty4'];
            } else {
                echo "<p> invalid qty4 </p>";
                $valid = FALSE;
            }
        }
        
        if($_POST['qty5']==""){
			$drum = 0;
		} else {
            if(filter_input(INPUT_POST, 'qty5', FILTER_VALIDATE_INT)){
                $drum = $_POST['qty5'];
            } else {
                echo "<p> invalid qty5 </p>";
                $valid = FALSE;
            }
        }

        // Hash to store the values for order form
        $cart = array (
			"Imac"=>[$imac, 1899.99],
			"Mouse"=>[$mouse, 79.99],
			"WD Hard Drive"=>[$wd,179.99],
			"Nexus"=>[$nexus,249.99],
			"Drums"=>[$drum, 119.99]
		);
    }
?>

<?php if($valid) :?>
    <!-- Create the table -->
    <!doctype html>
    <html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title> Thanks for shopping at the WebDev store! </title>
		<link rel="stylesheet" type="text/css" href="Styles.css" />
	</head> 
    <body>
    <h1> Thanks for your order <?= $name ?>.</h1>
    <h2> Here's a summary of your order: </h2>
    <table> 
        <tr> 
            <td colspan = "4"> <h3 class = "bold"> Address Information </h3> </td> 
        </tr>
        <tr> 
            <td> <p class="alignright"> Address: </p> </td>
            <td> <p> <?= $address ?> </p> </td>
            <td> <p class="alignright"> City: </p> </td>
            <td> <p> <?= $city ?> </p> </td>
        </tr>
        <tr>
	        <td ><p class="alignright"> Province: </p></td>
	        <td> <p> <?= $province ?> </p>	</td>
	        <td ><p class="alignright"> Postal Code: </p></td>
	        <td> <p> <?= $postCode ?> </p></td>
	    </tr>
        <tr> 
            <td colspan = "2"> <p class="alignright"> Email: </p> </td>
            <td colspan = "2"> <p> <?= $email ?> </p> </td>
        </tr>
    </table>
    <table> 
        <tr> 
            <td colspan = "3"> <h3 class="bold"> Order Information </h3> </td>
        </tr>
        <tr> 
            <td> <p class = "bold"> Quantity </p> </td>
            <td> <p class = "bold"> Description </p> </td>
            <td> <p class = "bold"> Cost </p> </td>
        </tr>
        <?php 
	      		$total = 0;
		  		foreach ($cart as $key=>$value){
		  			if($value[0] > 0){
		  				$cost = $value[0]*$value[1];
		  				$total = $total + $cost; ?>
		  				<tr>
                          <td> <?= $value[0] ?> </td>
                          <td> <?= $key ?> </td>
                          <td class='alignright'> <?= $cost ?> </td> 
                        </tr>
		  			<?php }
		  		}
		  	?>     
        <tr>  
            <td colspan ="2"> <p class = "bold"> Total: </p> </td>
            <td class = "alignright"> <p> <?= $total ?> </p> </td>
        </tr>
    </table>
<?php else : ?>
    <!-- if not valid show this message instead -->
    <h1> form could not be processed </h1>
<?php endif ?>
</body>
</html>
