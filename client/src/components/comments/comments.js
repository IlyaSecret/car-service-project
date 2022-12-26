import "./comments.scss";

export default function Comments() {
    return (
        <div className="comments">
            <p className="title">Отзывы</p>
            <div className="comments__vidget">
                <div style={{width:"750px", height:"800px", overflow:"hidden", position:"relative"}}><iframe style={{width:"100%", height:"100%", border:"1px solid #e6e6e6", borderRadius:"8px", boxSizing:"border-box"}} src="https://yandex.ru/maps-reviews-widget/1477862945?comments"></iframe><a href="https://yandex.ru/maps/org/avtohelp/1477862945/" target="_blank" style={{boxSizing:"border-box",textDecoration:"none",color:"#b3b3b3",fontSize:"10px",fontFamily:"YS Text sans-serif", padding:"0 20px", position:"absolute",bottom:"8px",width:"100%",textAlign:"center",left:"0",overflow:"hidden",textOverflow:"ellipsis",display:"block",maxHeight:"14px",whiteSpace:"nowrap",padding:"0 16px",boxSizing:"border-box"}}>АвтоHelp на карте Екатеринбурга — Яндекс Карты</a></div>
            </div>
        </div>
    );
}