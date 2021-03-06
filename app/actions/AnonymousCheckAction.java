/**
 * Yobi, Project Hosting SW
 *
 * Copyright 2013 NAVER Corp.
 * http://yobi.io
 *
 * @Author Wansoon Park, Keesun Baek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package actions;

import models.User;
import controllers.UserApp;
import controllers.routes;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.Constants;

/**
 * 현재 사용자가 anonymouse이면 로그인 페이지로 리다이렉트 한다.
 * 
 * @author Wansoon Park, Keesun Beak
 *
 */
public class AnonymousCheckAction extends Action.Simple {

    @Override
    public Result call(Context context) throws Throwable {
        User user = UserApp.currentUser();
        if(user.isAnonymous()) {
            play.mvc.Controller.flash(Constants.WARNING, "user.login.alert");
            return redirect(routes.UserApp.loginForm());
        }
        return this.delegate.call(context);
    }

}
