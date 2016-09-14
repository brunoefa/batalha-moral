$( document ).ready(function() {
    $("#btnC1").click(function() {
    	var idCandidato1 = $("#inputC1").val();
    	$("#vencedor").val(idCandidato1);
    	$("#batalha").submit();
    });
    
    $("#btnC2").click(function() {
    	var idCandidato2 = $("#inputC2").val();
    	$("#vencedor").val(idCandidato2);
    	$("#batalha").submit();
    });
});