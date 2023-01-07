import "./contacts.scss";

export default function Contacts() {
    return (
        <div className="contacts">
            <p className="title">Контакты</p>
            <div className="contacts__container">
                <div className="contacts__map">
                    <iframe src="https://yandex.ru/map-widget/v1/?um=constructor%3Adbda181943693563e4cd12207f845ebfc50e40bc7bbd0eba894b22c3618fa329&amp;source=constructor" width="802" height="580" frameborder="0"></iframe>
                </div>

                <div className="contacts__info">
                <div className="contacts__info__time">
                    <img src="./img/contacts-img/clock.png"></img>
                    <div>
                        <p>ПН-ПТ:</p>
                        <p>СБ:</p>
                        <p>ВС:</p>
                    </div>
                    <div>
                        <p>10:00 - 20:00</p>
                        <p>10:00 - 19:00</p>
                        <p>выходной</p>
                    </div>
                </div>

                <div className="contacts__info__time">
                    <img src="./img/contacts-img/map-pin.png"></img>
                    <div>
                        <p>г. Екатеринбург</p>
                        <p>Ул. Репина, д. 32</p>
                    </div>
                </div>

                <div className="contacts__info__time">
                    <img src="./img/contacts-img/phone.png"></img>
                    <div>
                        <p>+7 (343) 361-52-26</p>
                        <p>+7 (922) 181-52-26</p>
                    </div>
                </div>

                <div className="contacts__info__time">
                    <img src="./img/contacts-img/mail.png" id="mail"></img>
                    <div>
                        <p>avtohelp96@bk.ru</p>
                    </div>
                </div>
            </div>
            </div>



        </div>
    );
}
