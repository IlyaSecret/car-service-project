import "./footer.scss";

export default function Footer() {
    return (
        <div className="footer">

        <div className="contacts__info__time footer__right">
            <p>Часы работы: </p>
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

        <div className="footer__img">
            <img src="./img/logo.png"></img>
        </div>

        <div className="footer__left-info">
        <div className="contacts__info__time">
                    <img src="./img/white-footer/map-pin.png"></img>
                    <div>
                        <p>г. Екатеринбург</p>
                        <p>Ул. Репина, д. 32</p>
                    </div>
                </div>

                <div className="contacts__info__time">
                    <img src="./img/white-footer/phone.png"></img>
                    <div>
                        <p>+7 (343) 361-52-26</p>
                        <p>+7 (922) 181-52-26</p>
                    </div>
                </div>

                <div className="contacts__info__time">
                    <img src="./img/white-footer/mail.png" id="mail"></img>
                    <div>
                        <p>avtohelp96@bk.ru</p>
                    </div>
                </div>
        </div>
        </div>
    )
}