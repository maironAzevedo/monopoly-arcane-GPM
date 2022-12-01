### Como rodar o jogo

- É necessário ter o Java 17.0.2 instalado na máquina (o arquivo para instalação se encontra na pasta "monopoly" com o nome "jdk-17.0.2_windows-x64_bin.exe").
- Após isso, basta clicar no executável de nome "monopoly.exe" para gerar o jogo.
- Para sair do jogo, basta fechar a janela no "X".


# monopoly-arcane-GPM
Repositório criado no intuito de armazenar a aplicação desenvolvida para a disciplina "Gerência de projetos e manutenção" ministrada pelo professor Troy Costa Kohwalter em 2022.2.

## REQUISITOS MÍNIMOS
- InteliJ Community Version.
- Java 17.0.2.
- Maven latest version.

## Como gerar o build do projeto

Passo a passo:
- File.
- Project Structure.
- Artifacts.
- Clique em add.
- Selecione Jar.
- From modules with dependencies.
- Selecione a classe main (Launcher).
- Após isso, build.
- Selecione build artifacts.
- Selecione o artefato.

## Como gerar o exe

- Baixe o launch4jc (link para download: http://launch4j.sourceforge.net/).
- Escreva o local de saída do arquivo, lembre-se de colocar o ".exe" no final do nome.
- Escreva o local que está o Jar gerado.
- Vá até a aba JRE.
- Min JRE version: 17.0.2
- Clique na engrenagem.
- Ao gerar o exe, lembre-se de pôr os assets e JSON na mesma pasta do .exe
