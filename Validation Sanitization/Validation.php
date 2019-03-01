<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<title>Web Dev Order Form</title>
		<link rel="stylesheet" type="text/css" href="formstyles.css" />
	</head>
	<body>
		<h1>Web Dev Order Form</h1>
		<form id="orderform" action="confirmation.php" method="post">
			<fieldset id="orderInfo">
				<div class="left">
					<h3>Order Products</h3>
					<ul id="products">
						<li>					
							<p><img src="images/mac.png" alt="MacBook" />The MacBook&trade; comes with a 256GB SSD, 8GB RAM, 2.7GHz quad-core Intel Core i5 Processor, and a beautiful 13.1" display.
							<span>$1,899.99</span></p>
							
							<div class="quantityField" id="item1">
								<input id="qty1" name="qty1" class="qty" value="" type="text" placeholder="0" autofocus="autofocus" />
								<button type="button" id="addMac">Add</button>
							</div>

							<div class="clear"></div>
						</li>
						<li>					
							<p><img src="images/mouse.png" alt="Razer" />The Razer&trade; gaming mouse lives up to the expectations of gamers everywhere. Fast, durable, and attractive, it sets a new standard for gaming mice.
							<span>$79.99</span></p>
							
							<div class="quantityField" id="item2">
								<input id="qty2" name="qty2" class="qty" value="" type="text" placeholder="0" />
								<button type="button" id="addMouse">Add</button>
							</div>

							<div class="clear"></div>
						</li>
						<li>					
							<p><img src="images/wdehd.png" alt="WD HDD" />The WD My Passport portable hard drive has up to 2TB of space to store all your videos, music, and pictures. And with USB 3.0 connectivity.
							<span>$179.99</span></p>
							
							<div class="quantityField" id="item3">
								<input id="qty3" name="qty3" class="qty" value="" type="text" placeholder="0" />
								<button type="button" id="addWD">Add</button>
							</div>

							<div class="clear"></div>
						</li>
						<li>					
							<p><img src="images/nexus.png" alt="Nexus" />Google Nexus 7 has a stunning 7" LED display, 32GB of flash memory, an NVIDIA Tegra 3 quad core processor and 1 GB of RAM.
							<span>$249.99</span></p>
							
							<div class="quantityField" id="item4">
								<input id="qty4" name="qty4" class="qty" value="" type="text" placeholder="0" />
								<button type="button" id="addNexus">Add</button>
							</div>

							<div class="clear"></div>
						</li>
						<li>					
							<p><img src="images/drums.png" alt="Drums" />The DD-45 has four touch-sensitive pads plus a foot pedal, 99 world percussion sounds and a large selection of accompaniments make playing along with other instruments fun and easy. 
							<span>$119.99</span></p>

							<div class="quantityField" id="item5">
								<input id="qty5" name="qty5" class="qty" value="" type="text" placeholder="0" />
								<button type="button" id="addDrums">Add</button>
							</div>

							<div class="clear"></div>
						</li>
					</ul>
				</div>
				<div class="right">
					<h3>Cart</h3>
					<ul id="cart">
						<!--
						<li id="cartItem1">
							<p><img src="images/mac.png" alt="imac" /><span>iMac</span><br />
								Quantity: <span>2</span><br />
								Total: <span>$3799.98</span>						
							</p>
							<button id="removeItem1" type="button">Remove</button>
							<div class="clear"></div>
						</li>
						-->
						<li id="noItems">
							<p class="center noitems">No items in your cart</p>
						</li>
						<li id="total">
							<p>Total Order Amount: 
								<span id="cartTotal">$0.00</span>
							<p>
						</li>
					</ul>
					<p id="gotoShipping"><a href="#shippinginfo">Enter your shipping and payment information</a></p>
				</div>
			</fieldset>
			<fieldset id="paymentInfo">
				<div class="left">
					<a name="shippinginfo"><h3>Shipping Information</h3></a>
					<ul>
						<li>
							<label for="fullname">Full Name</label>
							<input id="fullname" name="fullname" type="text" />
						</li>
						<li>
							<label for="address">Address</label>
							<input id="address" name="address" type="text" />
						</li>
						<li>
							<label for="city">City</label>
							<input id="city" name="city" type="text" />
						</li>
						<li>
							<label for="province">Province</label>
							<select id="province" name="province">
								<option value=""></option>
								<option value="AB">Alberta</option>
								<option value="BC">British Columbia</option>
								<option value="MB">Manitoba</option>
								<option value="NB">New Brunswick</option>
								<option value="NL">Newfoundland and Labrador</option>
								<option value="NS">Nova Scotia</option>
								<option value="ON">Ontario</option>
								<option value="PE">Prince Edward Island</option>
								<option value="QC">Quebec</option>
								<option value="SK">Saskatchewan</option>
								<option value="NT">Northwest Territories</option>
								<option value="NU">Nunavut</option>
								<option value="YT">Yukon</option>
							</select>
						</li>
						<li>
							<label for="postal">Postal Code</label>
							<input id="postal" name="postal" type="text" />
						</li>
						<li>
							<label for="email">Email</label>
							<input id="email" name="email" type="text" />
						</li>
					</ul>
				</div>
				<div class="right">
					<h3>Payment Information</h3>					
					<fieldset id="cardTypes">
						<legend>Card Type</legend>
						<ul>
							<li>				
								<input id="visa" name="cardtype" value="visa" type="radio" />
								<label for="visa">VISA</label>
								<input id="amex" name="cardtype" value="amex" type="radio" />
								<label for="amex">AmEx</label>
								<input id="mastercard" name="cardtype" value="mastercard" type="radio" />
								<label for="mastercard">Mastercard</label>	
							</li>
						</ul>					
					</fieldset>					
					
					<fieldset id="cardInfo">
						<legend>Card Info</legend>
						<ul>
							<li>	
								<label for="cardname">Name on Card</label>
								<input id="cardname" name="cardname" type="text" />
							</li>	
							<li>							
								<label for="month">Expiry Date</label>
								<select id="month" name="month">
							        <option>- Month -</option>
							        <option value="1">January</option>
							        <option value="2">February</option>
							        <option value="3">March</option>
							        <option value="4">April</option>
							        <option value="5">May</option>
							        <option value="6">June</option>
							        <option value="7">July</option>
							        <option value="8">August</option>
							        <option value="9">September</option>
							        <option value="10">October</option>
							        <option value="11">November</option>
							        <option value="12">December</option>
								</select>
								<select id="year" name="year">
									<option>- Year -</option>
							        <option value = 2019> 2019 </option>
							        <option value="2020"> 2020 </option>
							        <option value="2021"> 2021 </option>
							        <option value="2022"> 2022 </option>
							        <option value="2023"> 2023 </option>
									<option value="2024"> 2024</option>
								</select>
							</li>
							<li>
								<label for="cardnumber">Card Number</label>
								<input id="cardnumber" name="cardnumber" type="number" />
							</li>
						</ul>	
					</fieldset>
				</div>
				<div class="clear"></div>
				<p class="center">
					<input type="submit" id="submit" name="submit">
					<button type="reset" id="clear">Clear Order</button>
				</p>
			</fieldset>
        </form>    
	</body>
</html>