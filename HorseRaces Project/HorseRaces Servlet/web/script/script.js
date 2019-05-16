const dom = (function (lang) {

    let en = {
        buttonSubmit: 'Accept',
        raceNumber: 'Race number',
        raceNumberPlaceholder: 'Enter race number',
        racesDate: 'Race date',
        racesDatePlaceholder: 'Enter race date',
        login: 'Login',
        loginPlaceholder: 'Enter login',
        password: 'Password',
        passwordPlaceholder: 'Enter password',
        passwordRepeat: 'Repeat password',
        passwordRepeatPlaceholder: 'Enter password again',
        buttonRegistration: 'Register',
        buttonLogout: 'Log out',
        buttonLogin: 'Log in',
        buttonLoginAsGuest: 'Login as guest',
        horseNumber: 'Horse number',
        horseNumberPlaceholder: 'Enter horse number',
        horsePlace: 'Position',
        horsePlacePlaceholder: 'Enter horse position',
    };

    let ru = {
        buttonSubmit: 'Подтвердить',
        raceNumber: 'Номер забега',
        raceNumberPlaceholder: 'Введите номер забега',
        racesDate: 'Дата забегов',
        racesDatePlaceholder: 'Введите дату забегов',
        login: 'Логин',
        loginPlaceholder: 'Введите логин',
        password: 'Пароль',
        passwordPlaceholder: 'Введите пароль',
        passwordRepeat: 'Повторите пароль',
        passwordRepeatPlaceholder: 'Повторите ввод пароля',
        buttonRegistration: 'Зарегистрироваться',
        buttonLogout: 'Выйти',
        buttonLogin: 'Войти',
        buttonLoginAsGuest: 'Войти как гость',
        horseNumber: 'Номер лошади',
        horseNumberPlaceholder: 'Введите номер лошади',
        horsePlace: 'Место',
        horsePlacePlaceholder: 'Введите место лошади',
    };

    function getLocale(lang) {
        return lang === 'ru' ? ru : en;
    }

    let locale = getLocale(lang);

    var formId = "";

    const winnersInRaceFrom = {
        raceId: {
            label: locale['raceNumber'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['raceNumberPlaceholder'],
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    const horsesInRaceFrom = {
        raceId: {
            label: locale['raceNumber'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['raceNumberPlaceholder'],
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    const racesByDateFrom = {
        date: {
            label: locale['racesDate'],
            type: 'date',
            class: 'form-control',
            placeholder: locale['racesDatePlaceholder'],
            name: 'date',
            id: 'date-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    const loginFrom = {
        login: {
            label: locale['login'],
            type: 'text',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input',
        },
        password: {
            label: locale['password'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLogin']
        }
    };

    const registrationForm = {
        login: {
            label: locale['login'],
            type: 'text',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input',
        },
        password: {
            label: locale['password'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input',
        },
        repeatPassword: {
            label: locale['passwordRepeat'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordRepeatPlaceholder'],
            name: 'repeat-password',
            id: 'password-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonRegistration']
        }
    };

    const guestForm = {
        login: {
            type: 'hidden',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input',
        },
        password: {
            type: 'hidden',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLoginAsGuest']
        }
    };

    const logoutForm = {
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLogout']
        }
    };

    const horsesResultFrom = {
        raceId: {
            label: locale['raceNumber'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['raceNumberPlaceholder'],
            name: 'raceId',
            minValue: '1',
            step: '1',
            id: 'raceId-input',
        },
        horseId: {
            label: locale['horseNumber'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['horseNumberPlaceholder'],
            name: 'horseId',
            minValue: '1',
            step: '1',
            id: 'horseId-input',
        },
        position: {
            label: locale['horsePlace'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['horsePlacePlaceholder'],
            name: 'positionNumber',
            minValue: '1',
            step: '1',
            id: 'position-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
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
            case 'guestForm':
                array = guestForm;
                actionValue = 'login';
                break;
            case 'logoutForm':
                array = logoutForm;
                actionValue = 'logout';
                break;
            case 'registrationForm':
                array = registrationForm;
                actionValue = 'registration';
                break;
        }

        for (const prop in array) {
            switch (array[prop].type) {
                default:
                    const formDiv = document.createElement('div');
                    formDiv.setAttribute('class', 'form-group');

                    if (array[prop].label != null) {
                        const label = document.createElement('label');
                        label.innerHTML = array[prop].label;
                        formDiv.appendChild(label);
                    }

                    const input = document.createElement('input');
                    input.setAttribute('type', array[prop].type);
                    input.setAttribute('class', array[prop].class);
                    input.setAttribute('placeholder', array[prop].placeholder);
                    input.setAttribute('name', array[prop].name);
                    input.setAttribute('min', array[prop].minValue);
                    input.setAttribute('step', array[prop].step);
                    input.setAttribute("id", array[prop].id);
                    input.setAttribute('lang', lang === 'ru' ? 'ru' : 'en');
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

        const guestForm = document.getElementById('as-guest-form');
        if (guestForm != null) {
            buildForm(guestForm, 'guestForm');
            console.log('guestForm');
            formId = 'as-guest-form';
        }


        const logoutForm = document.getElementById('logout-form');
        if (logoutForm != null) {
            buildForm(logoutForm, 'logoutForm');
            console.log('logoutForm');
            formId = 'logout-form';
        }

        const registrationForm = document.getElementById('registration-form');
        if (registrationForm != null) {
            buildForm(registrationForm, 'registrationForm');
            console.log('registrationForm');
            formId = 'registration-form';
        }

    }

    return {
        initPage,
    }

}());

dom.initPage();