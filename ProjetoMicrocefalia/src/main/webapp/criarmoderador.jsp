<%-- 
    Document   : cadastrousuario
    Created on : 03/10/2016, 19:29:51
    Author     : Gilberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ativar Como Moderador</title>
    </head>
    <body>

        <h1>ESPECIALIDADES MÉDICA</h1>
        <form action="forumcontroller.do?acao=ativar" method="POST">
            Escolha uma especialidade:
            <select name="acao" required >
                <option value="especialidade">Please select</option>
                <option value="Anatomia Patológica"> Anatomia Patológica</option>
                <option value="">Anestesiologia</option>
                <option value="">Angiologia e Cirurgia Vascular</option>
                <option value="">Cardiologia</option>
                <option value="">Cardiologia Pediátrica</option>
                <option value="">Cirurgia Cardiotorácica</option>
                <option value="">Cirurgia Geral</option>
                <option value="">Cirurgia Maxilo-Facial</option>
                <option value="">Cirurgia Pediátrica</option>
                <option value="">Cirurgia Plástica Reconstrutiva e Estética</option>
                <option value="">Dermato-Venereologia</option>
                <option value="">Doenças Infecciosas</option>
                <option value="">Endocrinologia e Nutrição</option>
                <option value="">Estomatologia</option>
                <option value="">Gastrenterologia</option>
                <option value="">Genética Médica</option>
                <option value="">Ginecologia/Obstetrícia</option>
                <option value="">Imunoalergologia</option>
                <option value="">Imunohemoterapia</option>
                <option value="">Farmacologia Clínica</option>
                <option value="">Hematologia Clínica</option>
                <option value="">Medicina Desportiva</option>
                <option value="">Medicina do Trabalho</option>
                <option value="">Medicina Física e de Reabilitação</option>
                <option value="">Medicina Geral e Familiar</option>
                <option value="">Medicina Interna</option>
                <option value="">Medicina Legal</option>
                <option value="">Medicina Nuclear</option>
                <option value="">Medicina Tropical</option>
                <option value="">Nefrologia</option>
                <option value="">Neurocirurgia</option>
                <option value="">Neurologia</option>
                <option value="">Neurorradiologia</option>
                <option value="">Oftalmologia</option>
                <option value="">Oncologia Médica</option>
                <option value="">Ortopedia</option>
                <option value="">Otorrinolaringologia</option>
                <option value="">Patologia Clínica</option>
                <option value="">Pediatria</option>
                <option value="">Pneumologia</option>
                <option value="">Psiquiatria</option>
                <option value="">Psiquiatria da Infância e da Adolescência</option>
                <option value="">Radiologia</option>
                <option value="">Radioncologia</option>
                <option value="">Reumatologia</option>
                <option value="">Saúde Pública</option>
                <option value="">Urologia</option>
            </select>
            <button type="submit">Enviar</button>
        </form>

    </body>
</html>
