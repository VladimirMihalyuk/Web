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

    const loginFrom = {
        login: {
            label: 'Логин',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login',
            id: 'login-input',
        },
        password: {
            label: 'Пароль',
            type: 'password',
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password',
            id: 'password-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Войти'
        }
    };

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

    function buildForm(form, type) {
        var array;
        var actionValue;
        switch (type) {
            case 'winnersInRaceForm':
                array = winnersInRaceFrom;
                actionValue = 'winnersByRace';
                break;
            case 'horsesInRaceForm':
                array = horsesInRaceFrom;
                actionValue = 'horsesInRace';
                break;
            case 'racesByDateForm':
                array = racesByDateFrom;
                actionValue = 'racesByDate';
                break;
            case 'horseResultForm':
                array = horsesResultFrom;
                actionValue = 'saveResult';
                break;
            case 'loginForm':
                array = loginFrom;
                actionValue = 'login';
                break;
        }

        for (const prop in array) {
            switch (array[prop].type) {
                default:
                    const formDiv = document.createElement('div');
                    formDiv.setAttribute('class', 'form-group');

                    const label = document.createElement('label');
                    label.innerHTML = array[prop].label;
                    formDiv.appendChild(label);

                    const input = document.createElement('input');
                    input.setAttribute('type', array[prop].type);
                    input.setAttribute('class', array[prop].class);
                    input.setAttribute('placeholder', array[prop].placeholder);
                    input.setAttribute('name', array[prop].name);
                    input.setAttribute('min', array[prop].minValue);
                    input.setAttribute('step', array[prop].step);
                    input.setAttribute("id", array[prop].id);
                    input.required = true;
                    formDiv.appendChild(input);

                    form.appendChild(formDiv);
                    break;
                case "submit":
                    const hiddenInput = document.createElement('input');
                    hiddenInput.setAttribute('name', 'action');
                    hiddenInput.setAttribute('type', 'hidden');
                    hiddenInput.setAttribute('id', 'action');
                    hiddenInput.setAttribute('value', actionValue);
                    form.appendChild(hiddenInput);

                    const submit = document.createElement('input');
                    submit.setAttribute('type', array[prop].type);
                    submit.setAttribute('class', array[prop].class);
                    submit.value = array[prop].value;
                    form.appendChild(submit);

                    break;
            }
        }
    }

    function initPage() {

        const winnersInRaceForm = document.getElementById('winners-in-race-form');
        if (winnersInRaceForm != null) {
            buildForm(winnersInRaceForm, 'winnersInRaceForm');
            console.log('winnersInRaceForm');
            formId = 'winners-in-race-form';
            return
        }

        const horsesInRaceForm = document.getElementById('horses-in-race-form');
        if (horsesInRaceForm != null) {
            buildForm(horsesInRaceForm, 'horsesInRaceForm');
            console.log('horsesInRaceForm');
            formId = 'horses-in-race-form';
            return
        }

        const racesByDateForm = document.getElementById('races-by-date-form');
        if (racesByDateForm != null) {
            buildForm(racesByDateForm, 'racesByDateForm');
            console.log('racesByDateForm');
            formId = 'races-by-date-form';
            return
        }

        const horseResultForm = document.getElementById('update-horse-result-form');
        if (horseResultForm != null) {
            buildForm(horseResultForm, 'horseResultForm');
            console.log('horseResultForm');
            formId = 'update-horse-result-form';

        }

        const loginForm = document.getElementById('login-form');
        if (loginForm != null) {
            buildForm(loginForm, 'loginForm');
            console.log('loginForm');
            formId = 'login-form';
        }
    }

    return {
        initPage,
    }

}());

dom.initPage();