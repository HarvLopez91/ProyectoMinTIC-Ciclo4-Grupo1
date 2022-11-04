# ProyectoMinTICiclo4
ProyectoMinTICiclo4 Grupo#1

No todos los archivos que agregas a un proyecto deberían ir a un repositorio. Por ejemplo, cuando tienes un archivo donde están tus contraseñas que comúnmente tienen la extensión .env o cuando te estás conectando a una base de datos; son archivos que nadie debe ver.

Por diversas razones, no todos los archivos que agregas a un proyecto deberían guardarse en un repositorio. Esto es porque hay archivos que no todo el mundo debería de ver, y hay archivos que al estar en el repositorio ralentizan el proceso de desarrollo (por ejemplo: los binary large objects, blob, que tardan en descargarse).

Para que no se suban estos archivos no deseados se puede crear un archivo con el nombre .gitignore en la raíz del repositorio con las reglas para los archivos que no se deberían subir: Aquí puedes ver la sintaxis de los .gitignore: https://git-scm.com/docs/gitignore

Las razones principales para tomar la decisión de no agregar un archivo a un repositorio son:

Es un archivo con contraseñas (normalmente con la extensión .env)
Es un blob (binary large object, objeto binario grande), mismos que son difíciles de gestionar en git.
Son archivos que se generan corriendo comandos, por ejemplo la carpeta node_modules, que genera npm al correr el comando npm install


---


README.md es el lugar donde se explica de qué trata el proyecto, cómo utilizarlo y demás información que se considere que se deba conocer cualquier persona que vaya a trabajar de alguna forma con el proyecto.
.
Los archivos README son escritos en un lenguaje llamado markdown, por eso la extensión .md, mismo que es un estándar de escritura en diversos sitios (como Platzi, Wikipedia y el mismo GitHub). Aquí puedes ver las reglas de markdown: https://www.markdownguide.org/extended-syntax

Los README.md pueden estar en todas las carpetas, pero el más importante es el que se encuentra en la raíz. Este documento ayuda a que los colaboradores sepan información relevante del proyecto, módulo o sección. Puedes crear cualquier archivo con la extensión .md pero solo los README.md los mostrará por defecto GitHub.

https://pandao.github.io/editor.md/en.html