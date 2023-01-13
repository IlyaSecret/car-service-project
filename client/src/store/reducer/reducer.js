
import {createSlice} from '@reduxjs/toolkit';
import { AuthorizationStatus } from '../../consts';
import { findUser } from '../../utils/find-user';

const initialState = {
    authStatus: AuthorizationStatus.NoAuth,
    authError: false,
    userData: []
}
export const mainReducerSlice = createSlice({
    name: 'main',
    initialState,
    reducers: {
        resetState: (state) => {
            return initialState
        },
        getUserData: (state, action) => {
            if (findUser(action.payload) !== undefined) {
                state.authStatus = AuthorizationStatus.Auth
                state.userData = findUser(action.payload);
            }
            else {
                state.authError = true;
            }
        }
    },
})


export const {
    resetState,
    getUserData
} = mainReducerSlice.actions;
export default mainReducerSlice.reducer;