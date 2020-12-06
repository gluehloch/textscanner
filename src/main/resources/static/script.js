"use strict";

console.log("Loading...");

export default class Client {

    constructor() {
        this.form = document.querySelector('#startscan');
        this.form.onsubmit = this.onSubmit;
    }

    onSubmit(event) {
        event.preventDefault();        
        var fileSelects = document.querySelector('#fileselects');
        var formData = new FormData();
        var files = fileSelects.files;
        for(var i = 0; i < files.length; i++){
            var file = files[i];

            // TODO Check the file type
            if (!/image.*/.test(file.type)) {
                return;
            }

            // Add the file to the form's data
            formData.append('files', file, file.name);
        }

        var xhr = new XMLHttpRequest();
        xhr.onload = function () {
            // uploadButton.innerHTML = 'Upload';
            if (xhr.status === 200) {
                const message = document.querySelector('#response');
                //var node = document.createElement("p");
                var textnode = document.createTextNode(xhr.responseText);
                message.append(textnode);
                // message.innerHTML = node;
            } else {
                alert('Something went wrong uploading the file.');
            }
        };

        xhr.open('POST', './scan', true);
        xhr.send(formData);
    }

}

new Client();
