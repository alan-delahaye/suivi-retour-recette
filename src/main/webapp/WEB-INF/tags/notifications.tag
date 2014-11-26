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
						<br /> Le périmètre <a href="#">Lot 5</a> a été finalisé.<br />
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
						<br /> ATTENTION : Le périmètre <a href="#">Lot 3 P4</a> est à
						surveillé.<br />
					</p>
				</div>
			</div>

			<!-- USERS ONLINE SECTION -->
			<h3>Membres de l'équipe</h3>
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