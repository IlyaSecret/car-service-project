import { useSelector } from "react-redux";
import "./personal-info.scss";


export default function PersonalInfo() {
    const user = useSelector(state => state.userData);
    return (
        <div className="personal-info">
            <h1>Об аккаунте</h1>

            <div className="personal-info__content">
                <p><span className="personal__title">ФИО:</span> {user.fullName} </p> 
                <p><span className="personal__title">Номер телефона:</span> {user.phoneNumber}</p>
                <p><span className="personal__title">Гос. Номер:</span> {user.vehicleNumber}</p>
            </div>

            {user.fullName === "admin" ? 
                <button className="admin_button"><a href="../../all-services/vigruzka.xlsx" download>Скачать выгрузку</a></button>
                : null
            }
        </div>
    )
}