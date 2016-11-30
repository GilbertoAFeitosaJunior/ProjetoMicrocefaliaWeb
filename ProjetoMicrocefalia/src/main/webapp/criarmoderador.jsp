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
        <a href="forum.jsp">VOLTAR</a>
        <h1>ESPECIALIDADES MÉDICA</h1>
        <form action="forumcontroller.do?acao=ativar" method="POST">
            Escolha uma especialidade:
            <select name="especialidade" required >
                <option value="">Please select</option>
                <option value="Anatomia Patológica"> Anatomia Patológica</option>
                <option value="Anestesiologia">Anestesiologia</option>
                <option value="Angiologia e Cirurgia Vascular">Angiologia e Cirurgia Vascular</option>
                <option value="Cardiologia">Cardiologia</option>
                <option value="Cardiologia Pediátrica">Cardiologia Pediátrica</option>
                <option value="Cirurgia Cardiotorácica">Cirurgia Cardiotorácica</option>
                <option value="Cirurgia Geral">Cirurgia Geral</option>
                <option value="Cirurgia Maxilo-Facial">Cirurgia Maxilo-Facial</option>
                <option value="Cirurgia Pediátrica">Cirurgia Pediátrica</option>
                <option value="Cirurgia Plástica Reconstrutiva e Estética">Cirurgia Plástica Reconstrutiva e Estética</option>
                <option value="Dermato-Venereologia">Dermato-Venereologia</option>
                <option value="Doenças Infecciosas">Doenças Infecciosas</option>
                <option value="Endocrinologia e Nutrição">Endocrinologia e Nutrição</option>
                <option value="Estomatologia">Estomatologia</option>
                <option value="Gastrenterologia">Gastrenterologia</option>
                <option value="Genética Médica">Genética Médica</option>
                <option value="Ginecologia / Obstetrícia">Ginecologia / Obstetrícia</option>
                <option value="Imunoalergologia">Imunoalergologia</option>
                <option value="Imunohemoterapia">Imunohemoterapia</option>
                <option value="Farmacologia Clínica">Farmacologia Clínica</option>
                <option value="Hematologia Clínica">Hematologia Clínica</option>
                <option value="Medicina Desportiva">Medicina Desportiva</option>
                <option value="Medicina do Trabalho">Medicina do Trabalho</option>
                <option value="Medicina Física e de Reabilitação">Medicina Física e de Reabilitação</option>
                <option value="Medicina Geral e Familiar">Medicina Geral e Familiar</option>
                <option value="Medicina Interna">Medicina Interna</option>
                <option value="Medicina Legal">Medicina Legal</option>
                <option value="Medicina Nuclear">Medicina Nuclear</option>
                <option value="Medicina Tropical">Medicina Tropical</option>
                <option value="Nefrologia">Nefrologia</option>
                <option value="Neurocirurgia">Neurocirurgia</option>
                <option value="Neurologia">Neurologia</option>
                <option value="Neurorradiologia">Neurorradiologia</option>
                <option value="Oftalmologia">Oftalmologia</option>
                <option value="Oncologia Médica">Oncologia Médica</option>
                <option value="Ortopedia">Ortopedia</option>
                <option value="Otorrinolaringologia">Otorrinolaringologia</option>
                <option value="Patologia Clínica">Patologia Clínica</option>
                <option value="Pediatria">Pediatria</option>
                <option value="Pneumologia">Pneumologia</option>
                <option value="Psiquiatria">Psiquiatria</option>
                <option value="Psiquiatria da Infância e da Adolescência">Psiquiatria da Infância e da Adolescência</option>
                <option value="Radiologia">Radiologia</option>
                <option value="Radioncologia">Radioncologia</option>
                <option value="Reumatologia">Reumatologia</option>
                <option value="Saúde Pública">Saúde Pública</option>
                <option value="Urologia">Urologia</option>
            </select>
            <button type="submit">Enviar</button>
        </form>

    </body>
</html>
