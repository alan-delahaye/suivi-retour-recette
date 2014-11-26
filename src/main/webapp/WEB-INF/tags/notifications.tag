<%@taglib prefix="s" uri="/struts-tags"%>
<div class="col-lg-3 ds" style="margin-top: 40px;">
			<!--COMPLETED ACTIONS DONUTS CHART-->
			<h3>Notifications</h3>

			<!-- First Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme" style="background-color: #68DF4A"><i
						class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>15/11/2014</muted>
						<br /> Le p�rim�tre <a href="#">Lot 5</a> a �t� finalis�.<br />
					</p>
				</div>
			</div>
			<!-- Second Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme" style="background-color: #FF0000"><i
						class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>14/11/2014</muted>
						<br /> ATTENTION : Le p�rim�tre <a href="#">Lot 3 P4</a> est �
						surveill�.<br />
					</p>
				</div>
			</div>

			<!-- USERS ONLINE SECTION -->
			<h3>Membres de l'�quipe</h3>
			<!-- First Member -->
			<s:iterator value="tousLesUtilisateurs">
				<div class="desc">
					<div class="thumb">
						<img class="img-circle" src="img/ui-sam.jpg" width="35px"
							height="35px" align="">
					</div>
					<div class="details">
						<p>
							<a><s:property value="nom" /> <s:property value="prenom" /></a><br />
							<muted>
							<s:property value="adresseMail" /></muted>
						</p>
					</div>
				</div>
			</s:iterator>
		</div>
		<!-- /col-lg-3 -->
	</div>