<%@taglib prefix="s" uri="/struts-tags"%>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/jquery-1.8.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="js/jquery.sparkline.js"></script>
	<script src="js/jquery-ui-1.9.2.custom.min.js"></script>


	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>

	<script type="text/javascript" src="js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="js/gritter-conf.js"></script>
		<!--custom switch-->
	<script src="js/bootstrap-switch.js"></script>

	<!--script for this page-->
	<script src="js/sparkline-chart.js"></script>
	<script src="js/zabuto_calendar.js"></script>
	
	<script src="js/raphael-min.js"></script>
	<script src="js/morris.min.js"></script>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							// Initialisation de la position des notifications JS
							$.extend($.gritter.options, { 
							    position: 'bottom-left', // defaults to 'top-right' but can be 'bottom-left', 'bottom-right', 'top-left', 'top-right' (added in 1.7.1)
							});
// 							var unique_id = $.gritter
// 									.add({
// 										// (string | mandatory) the heading of the notification
// 										title : 'Bienvenue sur AGRAF!',
// 										// (string | mandatory) the text inside the notification
// 										text : 'Ici vous pourrez consulter/saisir le RAF des tâches en cours.',
// 										// (string | optional) the image to display on the left
// 										image : 'img/ui-sam.jpg',
// 										// (bool | optional) if you want it to fade out on its own or just sit there
// 										sticky : false,
// 										// (int | optional) the time you want it to be alive for before fading out
// 										time : '1000',
// 										// (string | optional) the class name you want to apply to that specific message
// 										class_name : 'my-sticky-class'
// 									});

							
							return false;
						});
	</script>

	<script type="application/javascript">
		
        $(document).ready(function () {
            $("[data-toggle='switch']").wrap('<div class="switch" />').parent().bootstrapSwitch();
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
	      
        function changeEtatPerimetre(id){
        	$("#dialog-confirm").html("Cette action sera irreversible. Voulez-vous continuer ?");
	        $("#dialog-confirm").dialog({
	            resizable: false,
	            modal: true,
	            title: "Confirmation finalisation périmètre",
	            height: 250,
	            width: 400,
	            buttons: {
	                "Oui": function () {
	                    $(this).dialog('close');
	                    changeStatePerimetre(id)
	                },
	                "Non": function () {
	                    $(this).dialog('close');
	                    location.reload();
	                }
	            }
	        });
        }
        
        function changeStatePerimetre(id){
        	$.ajax({
        	       type: 'POST',
        	       url:'changeEtatPerimetre.do?idPerimetre='+ id,
        	       success: function(data){
        	    	   var unique_id = $.gritter
						.add({
							position: 'bottom-left',
							// (string | mandatory) the heading of the notification
							title : 'Mise à jour du périmètre',
							// (string | mandatory) the text inside the notification
							text : 'Périmètre mis à jour avec succès.',
							// (bool | optional) if you want it to fade out on its own or just sit there
							sticky : false,
							// (int | optional) the time you want it to be alive for before fading out
							time : '5000',
							// (string | optional) the class name you want to apply to that specific message
							class_name : 'gritter-green'
						});
        	    	   	
        	        },
        	        error: function(dataerr){
        	        		var unique_id = $.gritter
	    						.add({
	    							position: 'bottom-left',
	    							// (string | mandatory) the heading of the notification
	    							title : 'Mise à jour du périmètre',
	    							// (string | mandatory) the text inside the notification
	    							text : 'ERREUR : le périmètre n\'a pas été mis à jour.',
	    							// (bool | optional) if you want it to fade out on its own or just sit there
	    							sticky : false,
	    							// (int | optional) the time you want it to be alive for before fading out
	    							time : '5000',
	    							// (string | optional) the class name you want to apply to that specific message
	    							class_name : 'gritter-red'
	    						});
        	        }
        	});
	   	    window.setTimeout( function () {location.reload();}, 3000 ); 
        }
    
	</script>