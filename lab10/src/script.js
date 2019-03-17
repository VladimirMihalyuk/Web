const dom = (function () {

    const winnesInRaceFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    const horsesInRaceFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    const racesByDateFrom = {
        date: {
            label: 'Дата забегов',
            type: 'date',
            class: 'form-control',
            placeholder: 'Введите дату забегов',
            name: 'date',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    const horsesResultFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
        },
        horseId: {
            label: 'Номер лошади',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер лошади',
            name: 'horseId',
        },
        position: {
            label: 'Место',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите место лошади',
            name: 'positionNumber',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    function buildWinnesFrom(form) {
        const raceIdDiv = document.createElement('div');
        raceIdDiv.setAttribute('class', 'form-group');

        const raceIdLabel = document.createElement('label');
        raceIdLabel.innerHTML = winnesInRaceFrom.raceId.label;
        raceIdDiv.appendChild(raceIdLabel);

        const raceIdInput = document.createElement('input');
        raceIdInput.setAttribute('type', winnesInRaceFrom.raceId.type);
        raceIdInput.setAttribute('class', winnesInRaceFrom.raceId.class);
        raceIdInput.setAttribute('placeholder', winnesInRaceFrom.raceId.placeholder);
        raceIdInput.setAttribute('name', winnesInRaceFrom.raceId.name);
        raceIdDiv.appendChild(raceIdInput);

        form.appendChild(raceIdDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', winnesInRaceFrom.submitButton.type);
        submit.setAttribute('class', winnesInRaceFrom.submitButton.class);
        submit.value = winnesInRaceFrom.submitButton.value;

        form.appendChild(submit);
    }


    function buildHorsesInRaceFrom(form) {
        const raceIdDiv = document.createElement('div');
        raceIdDiv.setAttribute('class', 'form-group');

        const raceIdLabel = document.createElement('label');
        raceIdLabel.innerHTML = horsesInRaceFrom.raceId.label;
        raceIdDiv.appendChild(raceIdLabel);

        const raceIdInput = document.createElement('input');
        raceIdInput.setAttribute('type', horsesInRaceFrom.raceId.type);
        raceIdInput.setAttribute('class', horsesInRaceFrom.raceId.class);
        raceIdInput.setAttribute('placeholder', horsesInRaceFrom.raceId.placeholder);
        raceIdInput.setAttribute('name', horsesInRaceFrom.raceId.name);
        raceIdDiv.appendChild(raceIdInput);

        form.appendChild(raceIdDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', horsesInRaceFrom.submitButton.type);
        submit.setAttribute('class', horsesInRaceFrom.submitButton.class);
        submit.value = horsesInRaceFrom.submitButton.value;

        form.appendChild(submit);
    }

    function buildRacesByDateForm(form) {
        const dateDiv = document.createElement('div');
        dateDiv.setAttribute('class', 'form-group');

        const dateLabel = document.createElement('label');
        dateLabel.innerHTML = racesByDateFrom.date.label;
        dateDiv.appendChild(dateLabel);

        const raceIdInput = document.createElement('input');
        raceIdInput.setAttribute('type', racesByDateFrom.date.type);
        raceIdInput.setAttribute('class', racesByDateFrom.date.class);
        raceIdInput.setAttribute('placeholder', racesByDateFrom.date.placeholder);
        raceIdInput.setAttribute('name', racesByDateFrom.date.raceId);
        dateDiv.appendChild(raceIdInput);

        form.appendChild(dateDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', racesByDateFrom.submitButton.type);
        submit.setAttribute('class', racesByDateFrom.submitButton.class);
        submit.value = racesByDateFrom.submitButton.value;

        form.appendChild(submit);
    }

    function buildHorseResultForm(form) {
        const raceIdDiv = document.createElement('div');
        raceIdDiv.setAttribute('class', 'form-group');

        const raceIdLabel = document.createElement('label');
        raceIdLabel.innerHTML = horsesResultFrom.raceId.label;
        raceIdDiv.appendChild(raceIdLabel);

        const raceIdInput = document.createElement('input');
        raceIdInput.setAttribute('type', horsesResultFrom.raceId.type);
        raceIdInput.setAttribute('class', horsesResultFrom.raceId.class);
        raceIdInput.setAttribute('placeholder', horsesResultFrom.raceId.placeholder);
        raceIdInput.setAttribute('name', horsesResultFrom.raceId.name);
        raceIdDiv.appendChild(raceIdInput);

        form.appendChild(raceIdDiv);

        const horseIdDiv = document.createElement('div');
        horseIdDiv.setAttribute('class', 'form-group');

        const horseIdLabel = document.createElement('label');
        horseIdLabel.innerHTML = horsesResultFrom.horseId.label;
        horseIdDiv.appendChild(horseIdLabel);

        const horseIdInput = document.createElement('input');
        horseIdInput.setAttribute('type', horsesResultFrom.horseId.type);
        horseIdInput.setAttribute('class', horsesResultFrom.horseId.class);
        horseIdInput.setAttribute('placeholder', horsesResultFrom.horseId.placeholder);
        horseIdInput.setAttribute('name', horsesResultFrom.horseId.name);
        horseIdDiv.appendChild(horseIdInput);

        form.appendChild(horseIdDiv);

        const positionDiv = document.createElement('div');
        positionDiv.setAttribute('class', 'form-group');

        const positionLabel = document.createElement('label');
        positionLabel.innerHTML = horsesResultFrom.position.label;
        positionDiv.appendChild(positionLabel);

        const positionInput = document.createElement('input');
        positionInput.setAttribute('type', horsesResultFrom.position.type);
        positionInput.setAttribute('class', horsesResultFrom.position.class);
        positionInput.setAttribute('placeholder', horsesResultFrom.position.placeholder);
        positionInput.setAttribute('name', horsesResultFrom.position.name);
        positionDiv.appendChild(positionInput);

        form.appendChild(positionDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', horsesResultFrom.submitButton.type);
        submit.setAttribute('class', horsesResultFrom.submitButton.class);
        submit.value = horsesResultFrom.submitButton.value;

        form.appendChild(submit);
    }

    function initPage(pageNumber) {

        const winnersInRaceForm = document.getElementById('winners-in-race-form');
        if (winnersInRaceForm != null) {
            buildWinnesFrom(winnersInRaceForm);
            console.log('winnersInRaceForm');
        }

        const horsesInRaceForm = document.getElementById('horses-in-race-form');
        if (horsesInRaceForm != null) {
            buildHorsesInRaceFrom(horsesInRaceForm);
            console.log('horsesInRaceForm');
        }

        const racesByDateForm = document.getElementById('races-by-date-form');
        if (racesByDateForm != null) {
            buildRacesByDateForm(racesByDateForm);
            console.log('racesByDateForm');
        }

        const horseResultForm = document.getElementById('update-horse-result-form');
        if (horseResultForm != null) {
            buildHorseResultForm(horseResultForm);
            console.log('horseResultForm');
        }

    }

    return {
        initPage,
    }

}());

dom.initPage();