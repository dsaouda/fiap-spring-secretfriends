class FlashMessage {

    constructor() {
        this.messages = {}; 
    }

    set(key, value) {
        this.messages[key] = value;
    }

    has(key) {
        return this.messages[key] !== null;
    }

    get(key) {
        if (this.messages[key] === undefined) {
            return null;
        }

        let value = this.messages[key];
        delete this.messages[key];

        return value;

    }
}

const flashMessage = new FlashMessage();
export default flashMessage;