const dom = (function () {

    var formId = "";

    const winnersInRaceFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    function buildWinnersFrom(form) {
        const raceIdDiv = document.createElement('div');
        raceIdDiv.setAttribute('class', 'form-group');

        const raceIdLabel = document.createElement('label');
        raceIdLabel.innerHTML = winnersInRaceFrom.raceId.label;
        raceIdDiv.appendChild(raceIdLabel);

        const raceIdInput = document.createElement('input');
        raceIdInput.setAttribute('type', winnersInRaceFrom.raceId.type);
        raceIdInput.setAttribute('class', winnersInRaceFrom.raceId.class);
        raceIdInput.setAttribute('placeholder', winnersInRaceFrom.raceId.placeholder);
        raceIdInput.setAttribute('name', winnersInRaceFrom.raceId.name);
        raceIdInput.setAttribute('min', winnersInRaceFrom.raceId.minValue);
        raceIdInput.setAttribute('step', winnersInRaceFrom.raceId.step);
        raceIdInput.setAttribute("id", winnersInRaceFrom.raceId.id);
        raceIdInput.required = true;
        raceIdDiv.appendChild(raceIdInput);

        form.appendChild(raceIdDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', winnersInRaceFrom.submitButton.type);
        submit.setAttribute('class', winnersInRaceFrom.submitButton.class);
        submit.value = winnersInRaceFrom.submitButton.value;

        form.appendChild(submit);
        form.onSubmit = onSubmit();
    }

    const horsesInRaceFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

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
        raceIdInput.setAttribute('min', horsesInRaceFrom.raceId.minValue);
        raceIdInput.setAttribute('step', horsesInRaceFrom.raceId.step);
        raceIdInput.setAttribute("id", horsesInRaceFrom.raceId.id);
        raceIdInput.required = true;
        raceIdDiv.appendChild(raceIdInput);

        form.appendChild(raceIdDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', horsesInRaceFrom.submitButton.type);
        submit.setAttribute('class', horsesInRaceFrom.submitButton.class);
        submit.value = horsesInRaceFrom.submitButton.value;

        form.appendChild(submit);
        form.onSubmit = onSubmit();
    }


    const racesByDateFrom = {
        date: {
            label: 'Дата забегов',
            type: 'date',
            class: 'form-control',
            placeholder: 'Введите дату забегов',
            name: 'date',
            id: 'date-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    function buildRacesByDateForm(form) {
        const dateDiv = document.createElement('div');
        dateDiv.setAttribute('class', 'form-group');

        const dateLabel = document.createElement('label');
        dateLabel.innerHTML = racesByDateFrom.date.label;
        dateDiv.appendChild(dateLabel);

        const dateInput = document.createElement('input');
        dateInput.setAttribute('type', racesByDateFrom.date.type);
        dateInput.setAttribute('class', racesByDateFrom.date.class);
        dateInput.setAttribute('placeholder', racesByDateFrom.date.placeholder);
        dateInput.setAttribute('name', racesByDateFrom.date.name);
        dateInput.setAttribute("id", racesByDateFrom.date.id);
        dateInput.required = true;
        dateDiv.appendChild(dateInput);

        form.appendChild(dateDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', racesByDateFrom.submitButton.type);
        submit.setAttribute('class', racesByDateFrom.submitButton.class);
        submit.value = racesByDateFrom.submitButton.value;

        form.appendChild(submit);
        form.onSubmit = onSubmit();
    }

    const horsesResultFrom = {
        raceId: {
            label: 'Номер забега',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер забега',
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        horseId: {
            label: 'Номер лошади',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер лошади',
            name: 'horseId',
            minValue: '1',
            step: '1',
            id: 'horseId-input',
        },
        position: {
            label: 'Место',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите место лошади',
            name: 'positionNumber',
            minValue: '1',
            step: '1',
            id: 'position-input',
        //    think
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

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
        raceIdInput.setAttribute('min', horsesResultFrom.raceId.minValue);
        raceIdInput.setAttribute('step', horsesResultFrom.raceId.step);
        raceIdInput.setAttribute("id", horsesResultFrom.raceId.id);
        raceIdInput.required = true;
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
        horseIdInput.setAttribute('min', horsesResultFrom.raceId.minValue);
        horseIdInput.setAttribute('step', horsesResultFrom.raceId.step);
        horseIdInput.setAttribute("id", horsesResultFrom.horseId.id);
        horseIdInput.required = true;
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
        positionInput.setAttribute('min', horsesResultFrom.raceId.minValue);
        positionInput.setAttribute('step', horsesResultFrom.raceId.step);
        positionInput.setAttribute("id", horsesResultFrom.position.id);
        positionInput.required = true;
        positionDiv.appendChild(positionInput);

        form.appendChild(positionDiv);

        const submit = document.createElement('input');
        submit.setAttribute('type', horsesResultFrom.submitButton.type);
        submit.setAttribute('class', horsesResultFrom.submitButton.class);
        submit.value = horsesResultFrom.submitButton.value;

        form.appendChild(submit);
        form.onSubmit = onSubmit();
    }

    function initPage(pageNumber) {

        const winnersInRaceForm = document.getElementById('winners-in-race-form');
        if (winnersInRaceForm != null) {
            buildWinnersFrom(winnersInRaceForm);
            console.log('winnersInRaceForm');
            formId = 'winners-in-race-form';
            return
        }

        const horsesInRaceForm = document.getElementById('horses-in-race-form');
        if (horsesInRaceForm != null) {
            buildHorsesInRaceFrom(horsesInRaceForm);
            console.log('horsesInRaceForm');
            formId = 'horses-in-race-form';
            return
        }

        const racesByDateForm = document.getElementById('races-by-date-form');
        if (racesByDateForm != null) {
            buildRacesByDateForm(racesByDateForm);
            console.log('racesByDateForm');
            formId = 'races-by-date-form';
            return
        }

        const horseResultForm = document.getElementById('update-horse-result-form');
        if (horseResultForm != null) {
            buildHorseResultForm(horseResultForm);
            console.log('horseResultForm');
            formId = 'update-horse-result-form';
            return
        }

    }

    function onSubmit() {

    }

    return {
        initPage,
        onSubmit
    }

}());

dom.initPage();